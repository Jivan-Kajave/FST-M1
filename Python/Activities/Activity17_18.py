import pandas as pd

data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

df = pd.DataFrame(data)

df.to_csv("../inputs/creds.csv", index=False)

creds=pd.read_csv("../inputs/creds.csv")
print(creds)

# Print the values in the Usernames column only
print("===============")
print(creds["Usernames"])

# Print the username and password of the second row
print("===============")
print("Username: ", creds["Usernames"][1], " | Password: ", creds["Passwords"][1])

#Sort the Usernames column in ascending order
print("===============")
df_sorted_usernames = df.sort_values(by='Usernames', ascending=True)
print("Sorted Usernames (ascending):\n", df_sorted_usernames)

#Sort the Passwords column in descending order
print("===============")
df_sorted_passwords = df.sort_values(by='Passwords', ascending=False)
print("\nSorted Passwords (descending):\n", df_sorted_passwords)