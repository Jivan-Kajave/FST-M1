listOne = [5, 12, 35, 16, 40, 18, 15]
listTwo = [23, 36, 8, 11, 47, 20, 33]

print("First List ", listOne)
print("Second List ", listTwo)

thirdList = []

for num in listOne:
    if (num % 2 != 0):
        thirdList.append(num)

for num in listTwo:
    if (num % 2 == 0):
        thirdList.append(num)

print("result List is:")
print(thirdList)