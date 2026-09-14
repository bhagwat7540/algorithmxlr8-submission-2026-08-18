<p align="center"><img src="https://algorithmxlr8.io/logo-mark.png" width="56" alt="AlgorithmXlr8.io logo" /></p>
<h3 align="center">AlgorithmXlr8.io</h3>
<p align="center"><sub>Solved and synced automatically from <a href="https://algorithmxlr8.io">AlgorithmXlr8.io</a></sub></p>

---

# Rotting Oranges

**Difficulty:** `Medium`

## Problem

Given a grid of 0/1/2 (empty/fresh/rotten), rot spreads 4-directionally each minute. Return minutes until no fresh remains, or -1.

Read rows and cols, then the grid. Print the single integer answer.

## Examples

### Example 1

**Input**
```
3 3
2 1 1
1 1 0
0 1 1
```
**Output**
```
4
```

**Explanation:** Multi-source BFS from the initial rotten orange, round by round.

---

Solved on [AlgorithmXlr8.io](https://algorithmxlr8.io/solve-dsa/rotting-oranges).