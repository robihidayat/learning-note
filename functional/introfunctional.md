## Functional

A method is a function that is attached to a class or object.
A function has four parts:
  1. name
  2. Return type
  3. Parameter list
  4. Body


Lambdas are anonymous functions whose type is inferred. They have two things:
(parameter list) -> body

lambda expresssions do not carry state
this is effectively final, as good as being declared final
closures carry state. They close-over (hence closure) the defining scope to bind to
variables that are not passed in as parameters. Here factor is closed over.
closures carry (immutable) state


We can pass objects to functions
We can create objects within functions
We can return objects from functions.
    

pure functions:
1. does not mutate or change anything
2. does not depend on anything that changes
at the least this code is confusing, hard to reason, and may lead to misunderstanding and errors.
Keep lambdas and closures pure. Don't mutate shared state from within or from outside.


Higher order functions:
We can pass functions to functions
We can create functions within functions
We can return functions from functions.


Imperative: what to do and how to do.    
Declarative: what to do not how to do.
Functional: Declarative + higher-order functions



Java 7 and earlier:
imperative + object-oriented
    
Java 8 and later:
imperative + functional +
object-oriented
    
    
imperative: tell what to do and also how to do it
declarative: tell what to do and *not* how to do it
functional: declarative + higher-order functions
    
functions:
we pass object to functions
we create object in functions
we return object from functions
    
higher-order function
we pass function to functions
we create function in functions
we return function from functions
    
leads to functional decomposition in addition to 
object decomposition


Java 7 and earlier:
imperative + object-oriented
    
Java 8 and later:
imperative + functional +
object-oriented
    
    
imperative: tell what to do and also how to do it
declarative: tell what to do and *not* how to do it
functional: declarative + higher-order functions
    
functions:
we pass object to functions
we create object in functions
we return object from functions
    
higher-order function
we pass function to functions
we create function in functions
we return function from functions
    
leads to functional decomposition in addition to 
object decomposition
    

Function has 4 things:
    name         
    return type
    parameter list
    body
            
lamda express: is an anonymous function whose return type
is inferred. It has only two things
parameter list
body
                
(parameter list) -> body