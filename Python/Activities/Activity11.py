fruit_shop = {
    "mango": 20,
    "apple": 10,
    "orange": 25,
    "grapes": 15
}

key_to_check = input("What are you looking for? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")