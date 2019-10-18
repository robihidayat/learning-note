## Streaming


streaming di java bisa didefinisikan sebagai sequence elemenet dari source yang bisa dilakukan process aggregation.
sourcenya bisa array atau collection.

streaming menjaga data asli, aggregate operasi atau bulk operasi bisa mempermudah kita memanipulasi process. 

most of the stream operations returns streams only. This help us creating chain of the stream operations.
This is called as pipe-lining.

### Java Streaming vs Collection

All of us have watch online videos on youtube or some other such website. When you start watching video, a small portion of file is first loaded into your computer and start playing. You don’t need to download complete video before start playing it. This is called streaming. I will try to relate this concept with respect to collections and differentiate with Streams.

At the basic level, the difference between Collections and Streams has to do with when things are computed.

A Collection is an in-memory data structure, which holds all the values that the data structure currently has—every element in the Collection has to be computed before it can be added to the Collection.

A Stream is a conceptually fixed data structure, in which elements are computed on demand.

Based on above points, if we list down the various characteristics of Stream, they will be as follows:
    Not a data structure
    Designed for lambdas
    Do not support indexed access
    Can easily be outputted as arrays or lists
    Lazy access supported
    Parallelizable


### Different ways to create streams

#### Stream.of(val1, val2, val3….)

```
public class StreamBuilders
{
     public static void main(String[] args)
     {
         Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
         stream.forEach(p -> System.out.println(p));
     }
}
```

#### Stream.of(arrayOfElements)

```
public class StreamBuilders
{
     public static void main(String[] args)
     {
         Stream<Integer> stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
         stream.forEach(p -> System.out.println(p));
     }
}

```

#### List.stream()

```
public class StreamBuilders
{
     public static void main(String[] args)
     {
         List<Integer> list = new ArrayList<Integer>();
 
         for(int i = 1; i< 10; i++){
             list.add(i);
         }
 
         Stream<Integer> stream = list.stream();
         stream.forEach(p -> System.out.println(p));
     }
}
```

#### Stream.generate() or Stream.iterate()

```
public class StreamBuilders
{
     public static void main(String[] args)
     {
         Stream<Date> stream = Stream.generate(() -> { return new Date(); });
         stream.forEach(p -> System.out.println(p));
     }
}
```



#### String chars or String tokens

```
public class StreamBuilders
{
     public static void main(String[] args)
     {
        IntStream stream = "12345_abcdefg".chars();
        stream.forEach(p -> System.out.println(p));
         
        //OR
         
        Stream<String> stream = Stream.of("A$B$C".split("\\$"));
        stream.forEach(p -> System.out.println(p));
     }
}

```


### Convert streams to collections

#### Convert Stream to List – Stream.collect( Collectors.toList() )
```
public class StreamBuilders {
     public static void main(String[] args){
         List<Integer> list = new ArrayList<Integer>();
         for(int i = 1; i< 10; i++){
             list.add(i);
         }
         Stream<Integer> stream = list.stream();
         List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0).collect(Collectors.toList());
         System.out.print(evenNumbersList);
     }
}
```

#### Convert Stream to array – Stream.toArray( EntryType[]::new )
```
public class StreamBuilders {
     public static void main(String[] args){
         List<Integer> list = new ArrayList<Integer>();
         for(int i = 1; i< 10; i++){
             list.add(i);
         }
         Stream<Integer> stream = list.stream();
         Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
         System.out.print(evenNumbersArr);
     }
}
```



### Core stream operations

#### Intermediate operations
Intermediate operations return the stream itself so you can chain multiple method calls in a row. Let’s learn important ones.
##### Stream.filter()
Filter accepts a predicate to filter all elements of the stream. This operation is intermediate which enables us to call another stream operation (e.g. forEach) on the result.

```
memberNames.stream().filter((s) -> s.startsWith("A"))
                    .forEach(System.out::println);
                                 
```
##### Stream.map()
The intermediate operation map converts each element into another object via the given function. The following example converts each string into an upper-cased string. But you can also use map to transform each object into another type.


```
memberNames.stream().filter((s) -> s.startsWith("A"))
                     .map(String::toUpperCase)
                     .forEach(System.out::println);

```
##### Stream.sorted()
Sorted is an intermediate operation which returns a sorted view of the stream. The elements are sorted in natural order unless you pass a custom Comparator.

Keep in mind that sorted does only create a sorted view of the stream without manipulating the ordering of the backed collection. The ordering of memberNames is untouched.

```
memberNames.stream().sorted()
                    .map(String::toUpperCase)
                    .forEach(System.out::println);

```


#### Terminal operations
Terminal operations return a result of a certain type instead of again a Stream.
##### Stream.forEach()
This method helps in iterating over all elements of a stream and perform some operation on each of them. The operation is passed as lambda expression parameter.

```
memberNames.forEach(System.out::println);

```
##### Stream.collect()
collect() method used to receive elements from a steam and store them in a collection and mentioned in parameter function.

```
List<String> memNamesInUppercase = memberNames.stream().sorted()
                            .map(String::toUpperCase)
                            .collect(Collectors.toList());

```
##### Stream.match()
Various matching operations can be used to check whether a certain predicate matches the stream. All of those operations are terminal and return a boolean result.

```
boolean matchedResult = memberNames.stream()
                    .anyMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);
 
matchedResult = memberNames.stream()
                    .allMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);
 
matchedResult = memberNames.stream()
                    .noneMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);

```
##### Stream.count()
Count is a terminal operation returning the number of elements in the stream as a long.

```
long totalMatched = memberNames.stream()
                    .filter((s) -> s.startsWith("A"))
                    .count();

```
##### Stream.reduce()
This terminal operation performs a reduction on the elements of the stream with the given function. The result is an Optional holding the reduced value.

```
Optional<String> reduced = memberNames.stream()
                    .reduce((s1,s2) -> s1 + "#" + s2);
 
reduced.ifPresent(System.out::println);

```



### Stream short-circuit operations
to break the operaton when match

#### Stream.anyMatch()
This will return true once a condition passed as predicate satisfy. It will not process any more elements.

```
boolean matched = memberNames.stream()
                    .anyMatch((s) -> s.startsWith("A"));
 
System.out.println(matched);
 
Output: true

```


#### Stream.findFirst()
It will return first element from stream and then will not process any more element.

```
String firstMatchedName = memberNames.stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst().get();
 
System.out.println(firstMatchedName);
 
Output: Lokesh
```

### Parallelism in Java Steam

we have efficient machinery for implementing parallel operations in our applications

```
public class StreamBuilders {
     public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
         for(int i = 1; i< 10; i++){
             list.add(i);
         }
         //Here creating a parallel stream
         Stream<Integer> stream = list.parallelStream(); 
         Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
         System.out.print(evenNumbersArr);
     }
}

```


### Stream Operations
#### Intermediate Operations

    filter()
    map()
    flatMap()
    distinct()
    sorted()
    peek()
    limit()
    skip()

#### Terminal Operations

    forEach()
    forEachOrdered()
    toArray()
    reduce()
    collect()
    min()
    max()
    count()
    anyMatch()
    allMatch()
    noneMatch()
    findFirst()
    findAny()


### Sort stream on multiple fields
Java 8 example to sort stream of objects by multiple fields using comparators and Comparator.thenComparing() method. This method returns a lexicographic-order comparator with another comparator. It gives the same effect as SQL group by clause.


#### Create comparators for multiple fields
To sort on multiple fields, we must first create comparator for each field on which we want to sort the stream. Then chain each comparator in desired order to give group by effect on complete sorting.

```
//first name comparator
Comparator<Employee> compareByFirstName = Comparator.comparing( Employee::getFirstName );
 
//last name comparator
Comparator<Employee> compareByLastName = Comparator.comparing( Employee::getLastName );
 
//Compare by first name and then last name (multiple fields)
Comparator<Employee> compareByFullName = compareByFirstName.thenComparing(compareByLastName);
 
//Using Comparator - pseudo code
list.stream().sorted( comparator ).collect();

```

#### Java stream sort on multiple fields – example
Example of using thenComparing() to create Comparator which is capable of sorting by multiple fields.


```
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
 
public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Employee> employees = getUnsortedEmployeeList();
         
        //Compare by first name and then last name
        Comparator<Employee> compareByName = Comparator
                                                .comparing(Employee::getFirstName)
                                                .thenComparing(Employee::getLastName);
         
        List<Employee> sortedEmployees = employees.stream()
                                        .sorted(compareByName)
                                        .collect(Collectors.toList());
        
        System.out.println(sortedEmployees);
    }
 
    private static ArrayList<Employee> getUnsortedEmployeeList()
    {
        ArrayList<Employee> list = new ArrayList<>();
        list.add( new Employee(2l, "Lokesh", "Gupta") );
        list.add( new Employee(1l, "Alex", "Gussin") );
        list.add( new Employee(4l, "Brian", "Sux") );
        list.add( new Employee(5l, "Neon", "Piper") );
        list.add( new Employee(3l, "David", "Beckham") );
        list.add( new Employee(7l, "Alex", "Beckham") );
        list.add( new Employee(6l, "Brian", "Suxena") );
        return list;
    }
}


[
    E [id=7, firstName=Alex,    lastName=Beckham],
    E [id=1, firstName=Alex,    lastName=Gussin],
    E [id=4, firstName=Brian,   lastName=Sux],
    E [id=6, firstName=Brian,   lastName=Suxena],
    E [id=3, firstName=David,   lastName=Beckham],
    E [id=2, firstName=Lokesh,  lastName=Gupta],
    E [id=5, firstName=Neon,    lastName=Piper]
]

```