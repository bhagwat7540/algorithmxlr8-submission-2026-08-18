<p align="center"><img src="https://algorithmxlr8.io/logo-mark.png" width="56" alt="AlgorithmXlr8.io logo" /></p>
<h3 align="center">AlgorithmXlr8.io</h3>
<p align="center"><sub>Solved and synced automatically from <a href="https://algorithmxlr8.io">AlgorithmXlr8.io</a></sub></p>

---

# Kth Largest Element in a Stream

**Difficulty:** `Easy`

## Problem

Design a class that tracks the kth largest element in a growing stream of numbers. It is initialized with k and an initial array of numbers, and supports add(val), which adds val to the stream and returns the current kth largest element.

Read n and k on the first line, then n space-separated integers (the initial stream) on the second line. Then read q on the next line, followed by q integers, one per line, each an add(val) call. Print one line per add call: the kth largest element in the stream after that addition.

## Examples

### Example 1

**Input**
```
4 3
4 5 8 2
1
3
```
**Output**
```
4
```

**Explanation:** After adding 3, the stream is 4,5,8,2,3; the 3rd largest is 4.

---

Solved on [AlgorithmXlr8.io](https://algorithmxlr8.io/solve-dsa/kth-largest-element-in-a-stream).