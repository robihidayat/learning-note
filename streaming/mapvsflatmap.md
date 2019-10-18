# Java Stream map() vs flatMap()

Stream interface has >map() and flatMap() methods and both are intermediate stream operations and return another stream as method output.

The primary difference between map() vs flatMap() is the return type of both methods.

```
map() is used for transformation only, but flatMap() is used for both transformation and flattening.

flatMap() = map() + Flattening

```

The map() method produces one output value for each input value in the stream. So if there are n elements in the stream, map() operation will produce a stream of n output elements.

```
List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
 
List<Integer> listOfIntegers = listOfStrings.stream()
                                .map(Integer::valueOf)
                                .collect(Collectors.toList());
 
System.out.println(listOfIntegers);     //[1, 2, 3, 4, 5]

```

flatMap() is two step process i.e. map() + Flattening. It helps in converting Collection<Collection<T>> to Collection<T>.


```
List<Integer> list1 = Arrays.asList(1,2,3);
List<Integer> list2 = Arrays.asList(4,5,6);
List<Integer> list3 = Arrays.asList(7,8,9);
 
List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
 
List<Integer> listOfAllIntegers = listOfLists.stream()
                            .flatMap(x -> x.stream())
                            .collect(Collectors.toList());
 
System.out.println(listOfAllIntegers);      //[1, 2, 3, 4, 5, 6, 7, 8, 9]

```