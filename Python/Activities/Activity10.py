num_tuple = (15, 22, 35, 49, 50, 60, 74)
print("Given list is ", num_tuple)

print("Elements that are divisible by 5:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)