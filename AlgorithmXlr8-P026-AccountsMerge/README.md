<p align="center"><img src="https://algorithmxlr8.io/logo-mark.png" width="56" alt="AlgorithmXlr8.io logo" /></p>
<h3 align="center">AlgorithmXlr8.io</h3>
<p align="center"><sub>Solved and synced automatically from <a href="https://algorithmxlr8.io">AlgorithmXlr8.io</a></sub></p>

---

# Accounts Merge

**Difficulty:** `Medium`

## Problem

Given accounts [name, emails...], merge accounts sharing any email (possibly transitively).

Read n, then n lines each "name k email1 email2 ... emailk". Print each merged account on its own line: name then sorted emails, space separated.

## Examples

### Example 1

**Input**
```
4
John 2 johnsmith@mail.com john_newyork@mail.com
John 2 johnsmith@mail.com john00@mail.com
Mary 1 mary@mail.com
John 1 johnnybravo@mail.com
```
**Output**
```
John john00@mail.com john_newyork@mail.com johnsmith@mail.com
Mary mary@mail.com
John johnnybravo@mail.com
```

**Explanation:** The two John accounts sharing johnsmith@mail.com merge together.

---

Solved on [AlgorithmXlr8.io](https://algorithmxlr8.io/solve-dsa/accounts-merge).