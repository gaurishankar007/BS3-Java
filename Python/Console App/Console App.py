class AccountManagement:
    def __init__(self):
        while True:
            print("\nEnter 'VA' to view account details.\n" "Enter 'AA' to add member.\n" 
                  "Enter 'SA' to search a member.\n" "Enter 'Q' to exit.")
            choice = input("-->")
            if choice == "VA":
                self.view_accounts()
            elif choice == "AA":
                self.add_account()
            elif choice == "SA":
                self.search_account()
            elif choice == "Q":
                break
            else:
                print("Invalid Input\n")

    def add_account(self):
        while True:
            print("\nEnter 'S' to add accounts.\n"  "Enter 'Q' to exit.")
            choice = input("-->")
            if choice == "S":
                name = input("\nEnter your name \n")
                address = input("Enter your address \n")
                phone_number = int(input("Enter your Phone number \n"))
                balance = int(input("Enter your Balance \n"))
                file = open("Account_Detail.txt", "a+")
                file.write(f"{name.replace(' ', '_')},{address},{phone_number},Rs.{balance}\n")
                file.close()
            elif choice == "Q":
                break
            else:
                print("Invalid Input\n")

    def view_accounts(self):
        file = open("Account_Detail.txt", 'r')
        data = file.readlines()
        for i in range(len(data)):
            replace_data = (data[i].replace('\n', '')).replace('_', ' ')
            print(f"{i + 1}.{replace_data}")

    def search_account(self):
        while True:
            print("\nEnter 'S' to search accounts.\n"  "Enter 'Q' to exit.")
            choice = input("-->")
            if choice == "S":
                file = open("Account_Detail.txt", 'r')
                data = file.readlines()
                members = []
                for i in data:
                    replace_data = (i.replace('\n', '')).replace(",", " ")
                    split_data = replace_data.split()
                    members.append(split_data)
                name = input("Enter name: ")
                for j in members:
                    if j[0].replace('_', " ") == name:
                        print(f"Name={j[0]}\n" f"Address={j[1]}\n" f"Number={j[2]}\n" f"Balance={j[3]}")
            elif choice == "Q":
                break
            else:
                print("Invalid Input\n")


Open = AccountManagement()
