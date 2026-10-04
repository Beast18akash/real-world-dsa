# Mr. String — Vowel Count & Pair Sum

## Problem

Given a list of numbers, convert each number into its textual representation.

Count the total number of vowels (`a, e, i, o, u`) present in all the textual representations. This total becomes **D**.

Then, find the number of unordered pairs from the input whose sum is equal to **D**.

Finally, print the number of pairs in its textual representation.

If the number of pairs is greater than `100`, print:

```text
greater 100
```

### Example

**Input**

```text
5
1 2 3 4 5
```

Textual representations:

```text
1 → one    → 2 vowels
2 → two    → 1 vowel
3 → three  → 2 vowels
4 → four   → 2 vowels
5 → five   → 2 vowels
```

Therefore:

```text
D = 2 + 1 + 2 + 2 + 2
D = 9
```

Now find pairs whose sum is `9`:

```text
4 + 5 = 9
```

There is only one pair.

So the output is:

```text
one
```

---

## Approach

The solution is divided into three main steps.

### 1. Convert numbers to text and calculate D

Two arrays are used to store the textual representation of numbers:

* `ones` → numbers from `0` to `19`
* `tens` → multiples of `10`

For numbers from `1` to `19`, the value is directly taken from `ones`.

For numbers from `20` to `99`, the tens and ones parts are combined.

For `100`, the representation is simply:

```text
hundred
```

Each character of the resulting string is checked to determine whether it is a vowel.

The total vowel count gives us `D`.

---

### 2. Find pairs whose sum is D

A `HashSet` is used to keep track of numbers that have already been processed.

For every number:

```text
required = D - current number
```

If `required` already exists in the set, a valid pair has been found.

Otherwise, the current number is added to the set.

For example, if:

```text
D = 9
current number = 5
```

then:

```text
required = 9 - 5
         = 4
```

If `4` is already in the set, then:

```text
4 + 5 = 9
```

is a valid pair.

---

### 3. Convert the pair count to text

The number of pairs is converted back into its textual representation using the same `ones` and `tens` arrays.

If the count is greater than `100`:

```text
greater 100
```

is printed.

---

## Data Structures Used

| Data Structure     | Purpose                              |
| ------------------ | ------------------------------------ |
| `String[]`         | Store number-to-word mappings        |
| `HashSet<Integer>` | Track previously encountered numbers |
| `int`              | Store vowel count and pair count     |

---

## Complexity

Let:

* `N` = number of input elements
* `L` = length of the textual representation of a number

### Time Complexity

Counting vowels:

```text
O(N × L)
```

Finding pairs using `HashSet`:

```text
O(N)
```

Therefore:

```text
O(N × L + N)
```

Since the problem restricts numbers to `1–100`, the length of the textual representation is bounded. Therefore, for this problem:

```text
Time Complexity: O(N)
```

### Space Complexity

The `HashSet` can contain up to `N` elements:

```text
Space Complexity: O(N)
```

---

## Complexity Summary

```text
Time Complexity:  O(N)
Space Complexity: O(N)
```

---

## Example

### Input

```text
5
1 2 3 4 5
```

### Calculation

```text
one    → 2 vowels
two    → 1 vowel
three  → 2 vowels
four   → 2 vowels
five   → 2 vowels

D = 9
```

Valid pair:

```text
4 + 5 = 9
```

Number of pairs:

```text
1
```

### Output

```text
one
```

---

## Concepts Practiced

* Arrays
* Strings
* Character traversal
* String manipulation
* HashSet
* Pair-sum technique
* Number-to-word conversion
* Time and space complexity analysis
