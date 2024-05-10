def calculate_sum(numbers):
    sum = 0
    for number in numbers:
        sum += number
    return sum

numList = [14, 30, 20, 45, 80]

result = calculate_sum(numList)

print("The sum of all the elements is: " + str(result))