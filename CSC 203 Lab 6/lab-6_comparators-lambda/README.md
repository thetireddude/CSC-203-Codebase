# Partner: Alejandro Corona Garibay

Sorting, comparisons and lambda
====================================================

Sorting/ordering data is a common technique used in computing
applications and, as such, Java has built-in support to allow for
various methods to compare data (which can then be used when sorting).
In addition, a closely related task, of specifying a small block of code
(computation) that can be passed around and executed later, is supported
in Java 8 with the added support for *lambda expressions*.
(Historically, there was some non-syntactic support in various libraries
even earlier than this). The inclusion of *lambda expressions* can aid
the programmer with common tasks (with comparisons being the first
example we will tackle in this lab). At the surface level, a lambda
expression can be seen as a syntactic simplification of a common use of
anonymous inner classes (or even plain classes). Though this syntactic
reduction is of great value, lambda expressions, coupled with additional
support throughout the Java libraries (in particular, the
`java.util.function` and `java.util.stream` packages), provide another
means for designing programming solutions.

This lab introduces the mechanics of lambda expressions as motivated by
the common task of comparing two objects. Later labs will revisit the
use of lambda expressions in different contexts.

Objectives
----------

-   To explore the task of comparing data using various Java mechanism,
    including comparators and lambdas

-   To practice using lambda expressions for comparisons to sort data

-   To practice understanding the application of lambda expressions via
    reading and understanding code examples using lambdas more generally
    (than just for sorting)

Comparators and Lambda Expressions
----------------------------------

Examine the provided files in the `comparator` directory.
You'll notice that it contains the `Applicant` and `CourseGrade` classes from Lab 1, with some additions to the `Applicant` class.

For this part we will compare different implementations of the `java.util.Comparator` interface, including the use of lambda  expressions.
A `Comparator` allows, via the `compare` method, one to compare two objects to determine which "comes before" the other.
For example, one might define a `Comparator<Integer>` to determine which of  two `Integer` objects comes first by ascending order.

Various methods take `Comparator` objects to generalize algorithms (such as sorting).
The benefit is that passing different `Comparator`s allows for changing the order.
Use of the `Comparator` interface (especially as opposed to the `Comparable` interface) allows one to remove the "ordering" logic from the objects to be compared.
Instead, this logic is placed elsewhere to allow for multiple "orderings" of the same data.

The `Comparator` interface requires its implementing classes to implement a `compare` method that takes two arguments and
returns an `int` value indicating the relative order of the arguments. A negative return value indicates that the first
parameter object "comes before"  the second; a positive return value indicates that the second parameter object "comes
before" the first; and zero indicates that the values are equivalent by the ordering.

### `NameComparator`

Define the `NameComparator` class (yes, for this part, as a class),
implementing `Comparator<Applicant>`, to compare two `Applicant` objects and order
them by name (in ascending order). The `Applicant` class is in the provided
code.

*For example, when you compare the first and second songs in the song list, the result should be less than 0, because
"Aakash" is lexically before "Sarah". Write another test case to test for alternative cases.*

Write a few tests of your `NameComparator` in the provided
`TestCases.java` by comparing two `Applicant` objects (you may use elements
of the `applicants` array).

### Average Comparator &mdash; As a Lambda Expression

Functional interfaces (those that declare only a single required method) can be "implemented" by lambda expressions.
A lambda expression is a stand-alone, anonymous function (in Java, they turn out to be shorthand for anonymous inner classes).

For this part you *will not* define a new class.
Instead, in `TestCases.java`, assign a lambda expression to a `Comparator<Applicant>` variable local to your testing method.
This lambda expression should act as a comparator on `Applicant` objects that orders them in ascending order of average grade.

_For example, when you compare the first and second applicants in the list ("Aakash" and "Sarah"), "Aakash" has a lower average than "Sarah". The comparator should return a number less than 0._

Write a few tests to verify that this comparator works. For the test cases you only need to compare two Applicants at a time
(but consider writing more than one comparison to accurately test your implementation).

### Years Of Experience Comparator &mdash; Using a Key Extractor

If you examine the Javadoc for `java.util.Comparator` interface, you will notice that there are many more methods than `compare` that can be useful.
Of note are the many static methods that can be used to create `Comparator`s based on a "key extractor" function.

Write a few test cases test a `Comparator<Applicant>` ordering by `yearsOfExperience`, in *descending* order
(in other words most recent songs would be listed first&mdash;getting this ordering proper may require a bit of research).
But for this part, you must use an appropriate `static` `comparing` method by providing a "key extractor" function.

*For example, when you compare the second and third applicants in the list, the result should now be greater than 0, because "Sarah" has 5 years of experience while "Moe" has 10,
and we are comparing in descending  order.*

### Comparator Composition

The comparators defined thus far compare only a single field to determine an ordering, but it is often the case that when trying to order two objects one might want
to order first by a primary key and then, if the primary key matches, by a secondary key.
For instance, one might wish to order applicants by years of experience and then by grade average for applicants with the same number of years of experience.

For this part you will define the `ComposedComparator` class, implementing `Comparator<Applicant>` (this class should be generic, but for now we will fix it to `Applicant` objects).
This comparator must define a constructor that takes two `Comparator<Applicant>` objects, `c1` and `c2`.
The `compare` method must be defined to use `c1` to compare the `Applicant` objects and then, if they are equivalent by the `c1` ordering, use `c2`.

Write a test using this comparator; be sure to select a pair of songs that demonstrate the sequencing behavior of this comparator.

*For example, when you compare "Sarah" and "Aakash" in the list, they both have the same amount of experience, but different averages. When compared think about what
the result would be based on their grade averages.* 

### `thenComparing`

Composition, or sequencing, of the sort in the previous part is a relatively common technique.
As such, the `Comparator` interface actually supports this via a (default) method named `thenComparing`.
On an existing comparator object, one can call `thenComparing` and pass to
it the next comparator to use in the sequence.

Declare a `Comparator<Applicant>` variable in a testing method and initialize it with a lambda expression (or using a key extractor) comparing Applicants by `yearsOfExperience`.
Then invoke `thenComparing` on this object passing to this method another comparator (or a key extractor) that will compare applicants by grade averages.
Write a test to verify that this comparator works as expected (i.e., orders by years of experience and by grade average when the years of experience match).

### `sort`

Using the technique in the last part (lambda expressions with
`thenComparing`), complete the sorting test by passing a comparator that
orders by name, then by years of experience, then by average (each in ascending order).

*For this test case, there is a correctly ordered song list to use for
your comparison.*


## Demo & Submission

After you finish the lab, compress the lab folder and submit it on CANVAS.