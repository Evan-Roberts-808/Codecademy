def multiplication(num_a, num_b):
    if num_a == 0 or num_b == 0:
        return 0

    return num_a + multiplication(num_a, num_b - 1)


# test cases:
print(multiplication(3, 7) == 21)
print(multiplication(5, 5) == 25)
print(multiplication(0, 4) == 0)
