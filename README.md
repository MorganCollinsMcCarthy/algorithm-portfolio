# Algorithm Portfolio 20290 Morgan Collins McCarthy

This is a collection of algorithms implemented throughout my academic year. The code is written to be readable and correct and has not been optimize. The algorithms have been tested and basic run time test have been implemented to analyse performance.

## Table of Contents
- [Russian Multiplication](src/algorithmPortfolio20290MorganCollinsMcCarthy/Lab1/RussianMultiplication.java)
- [Fibonacci](src/algorithmPortfolio20290MorganCollinsMcCarthy/Lab3/fibonacci.java)
- [Sorts](src/algorithmPortfolio20290MorganCollinsMcCarthy/Lab4and5and6/Sorts.java)
- [Searches](src/algorithmPortfolio20290MorganCollinsMcCarthy/lab7/search.java)
- [Trie](src/algorithmPortfolio20290MorganCollinsMcCarthy/Lab8/Trie.java)
- [Run Length Encoding](src/algorithmPortfolio20290MorganCollinsMcCarthy/Lab9/RunLengthEncoding.java)

### Full Breakdown
- Russian Multiplication [more info](https://en.wikipedia.org/wiki/Ancient_Egyptian_multiplication#Peasant_multiplication)
- Fibonacci [more info](https://en.wikipedia.org/wiki/Fibonacci_number)
- Quick Sort [more info](https://en.wikipedia.org/wiki/Quicksort)
- Merge Sort [more info](https://en.wikipedia.org/wiki/Merge_sort)
- Bogo Sort [more info](https://en.wikipedia.org/wiki/Bogosort)
- Insertion sort [more info](https://en.wikipedia.org/wiki/Insertion_sort)
- Selection sort [more info](https://en.wikipedia.org/wiki/Quicksort)
- Brute force string search [more info](http://www-inst.eecs.berkeley.edu/~cs61b/su06/lecnotes/lec28.pdf)
- KMP string search [more info](https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm)
- Trie and key searching [more info](https://en.wikipedia.org/wiki/Trie)
- Run Length Encoding [more info](https://en.wikipedia.org/wiki/Run-length_encoding)


Other files that have not been lisited above have been used for tasks such as compression and runtime analysis.

## Testing and Performance

Each algorithm can be tested in the main.java class. Methods for each algorithm have been included to output runtime performance.

### Example

Below are examples of tests to output the run time of sorts.

```
sortTest(0, "Selection Sort");
sortTest(1, "Insertion Sort");
sortTest(2, "Merge Sort");
sortTest(3, "Quick Sort");
sortTest(4, "Advanced Quick Sort");
```

The number of input tests can be modified by changing the input size and increment.
```
int inputSize = 0; inputSize <= 1000; inputSize += 50
```

Also the total runs per input can be changed by modifying this value.
```
int totalRuns = 100;
```
This is useful when dealing with different time complexity algorithms. Higher total runs can result in more accurate results.
Each test for each algorithm follows a simialar structure and can be modified by chaanging these values

## Authors

* **Morgan Collins McCarthy** - *Initial work* - [MorganCollinsMcCarthy](https://github.com/MorganCollinsMcCarthy)
