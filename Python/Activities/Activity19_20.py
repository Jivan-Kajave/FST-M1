import pandas as pd
from pandas import ExcelWriter

data = {
    'FirstName':["Satvik", "Avinash", "Lahri"],
    'LastName':["Shah", "Kati", "Rath"],
    'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
    'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

df = pd.DataFrame(data)

print(df)

writer = ExcelWriter('../inputs/sample.xlsx')
df.to_excel(writer, 'Sheet1', index=False)
writer._save()

df = pd.read_excel('../inputs/sample.xlsx')

print("====================================")
print("Number of rows and columns:", df.shape)

print("====================================")
print("Emails:")
print(df['Email'])

print("====================================")
print("Sorted data:")
print(df.sort_values('FirstName'))