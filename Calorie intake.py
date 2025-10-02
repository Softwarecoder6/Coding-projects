def women_bmr_none(lbs, inches, age):
    bmr = 65.51 + (4.35 * lbs) + (4.7 * inches) - (4.7 * age)
    total = bmr * 1.2
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def women_bmr_light(lbs, inches, age):
    bmr = 65.51 + (4.35 * lbs) + (4.7 * inches) - (4.7 * age)
    total = bmr * 1.375
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def women_bmr_moderate(lbs, inches, age):
    bmr = 65.51 + (4.35 * lbs) + (4.7 * inches) - (4.7 * age)
    total = bmr * 1.55
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def women_bmr_heavy(lbs, inches, age):
    bmr = 65.51 + (4.35 * lbs) + (4.7 * inches) - (4.7 * age)
    total = bmr * 1.725
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def women_bmr_extra_heavy(lbs, inches, age):
    bmr = 65.51 + (4.35 * lbs) + (4.7 * inches) - (4.7 * age)
    total = bmr * 1.9
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def men_bmr_none(lbs, inches, age):
    bmr = 66.47 + (6.24 * lbs) + (12.7 * inches) - (6.75 * age)
    total = bmr * 1.2
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def men_bmr_light(lbs, inches, age):
    bmr = 66.47 + (6.24 * lbs) + (12.7 * inches) - (6.75 * age)
    total = bmr * 1.375
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def men_bmr_moderate(lbs, inches, age):
    bmr = 66.47 + (6.24 * lbs) + (12.7 * inches) - (6.75 * age)
    total = bmr * 1.55
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def men_bmr_heavy(lbs, inches, age):
    bmr = 66.47 + (6.24 * lbs) + (12.7 * inches) - (6.75 * age)
    total = bmr * 1.725
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def men_bmr_extra_heavy(lbs, inches, age):
    bmr = 66.47 + (6.24 * lbs) + (12.7 * inches) - (6.75 * age)
    total = bmr * 1.9
    print(f'Your BMR is {bmr:.2f}')
    print(f'Amount of calories needed daily to maintain current weight is {total:.2f}')


def male():
    global check
    while True:
        try:
            weight = float(input('How much do you weigh (in pounds)? '))
        except ValueError:
            print("Sorry, I didn't understand that.")
            continue
        else:
            break
    while True:
        try:
            height = float(input('How tall are you (in inches)? '))
        except ValueError:
            print("Sorry, I didn't understand that.")
            continue
        else:
            break
    while True:
        try:
            age_input = float(input('How old are you? '))
        except ValueError:
            print("Sorry, I didn't understand that.")
            continue
        else:
            break
    while True:
        try:
            bmr_input = input('How many times do you exercise per week?\nA.0 times\nB.1-2 times\nC.2-3 times'
                              '\nD.3-4 times\nE.5-7 times\n')
        except ValueError:
            print("Sorry, I didn't understand that.")
            continue
        else:
            break
    check = True
    if bmr_input.upper() == 'A':
        check = True
        men_bmr_none(weight, height, age_input)
    elif bmr_input.upper() == 'B':
        check = True
        men_bmr_light(weight, height, age_input)
    elif bmr_input.upper() == 'C':
        check = True
        men_bmr_moderate(weight, height, age_input)
    elif bmr_input.upper() == 'D':
        check = True
        men_bmr_heavy(weight, height, age_input)
    elif bmr_input.upper() == 'E':
        check = True
        men_bmr_extra_heavy(weight, height, age_input)
    else:
        check = False
    while not check:
        bmr_input = input('Invalid input, how many times do you exercise per week?\nA.0 times\nB.1-2 times\nC.2-3 times'
                          '\nD.3-4 times\nE.5-7 times\n')
        if bmr_input.upper() == 'A':
            check = True
            women_bmr_none(weight, height, age_input)
        elif bmr_input.upper() == 'B':
            check = True
            women_bmr_light(weight, height, age_input)
        elif bmr_input.upper() == 'C':
            check = True
            women_bmr_moderate(weight, height, age_input)
        elif bmr_input.upper() == 'D':
            check = True
            women_bmr_heavy(weight, height, age_input)
        elif bmr_input.upper() == 'E':
            check = True
            women_bmr_extra_heavy(weight, height, age_input)
        else:
            check = False


def female():
    global check
    while True:
        try:
            weight = float(input('How much do you weigh (in pounds)? '))
        except ValueError:
            print("Sorry, I didn't understand that.")
            continue
        else:
            break
    while True:
        try:
            height = float(input('How tall are you (in inches)? '))
        except ValueError:
            print("Sorry, I didn't understand that.")
            continue
        else:
            break
    while True:
        try:
            age_input = float(input('How old are you? '))
        except ValueError:
            print("Sorry, I didn't understand that.")
            continue
        else:
            break
    while True:
        try:
            bmr_input = input('How many times do you exercise per week?\nA.0 times\nB.1-2 times\nC.2-3 times'
                              '\nD.3-4 times\nE.5-7 times\n')
        except ValueError:
            print("Sorry, I didn't understand that.")
            continue
        else:
            break
    check = True
    if bmr_input.upper() == 'A':
        check = True
        women_bmr_none(weight, height, age_input)
    elif bmr_input.upper() == 'B':
        check = True
        women_bmr_light(weight, height, age_input)
    elif bmr_input.upper() == 'C':
        check = True
        women_bmr_moderate(weight, height, age_input)
    elif bmr_input.upper() == 'D':
        check = True
        women_bmr_heavy(weight, height, age_input)
    elif bmr_input.upper() == 'E':
        check = True
        women_bmr_extra_heavy(weight, height, age_input)
    else:
        check = False
    while not check:
        bmr_input = input('Invalid input, how many times do you exercise per week?\nA.0 times\nB.1-2 times\nC.2-3 times'
                          '\nD.3-4 times\nE.5-7 times\n')
        if bmr_input.upper() == 'A':
            check = True
            women_bmr_none(weight, height, age_input)
        elif bmr_input.upper() == 'B':
            check = True
            women_bmr_light(weight, height, age_input)
        elif bmr_input.upper() == 'C':
            check = True
            women_bmr_moderate(weight, height, age_input)
        elif bmr_input.upper() == 'D':
            check = True
            women_bmr_heavy(weight, height, age_input)
        elif bmr_input.upper() == 'E':
            check = True
            women_bmr_extra_heavy(weight, height, age_input)
        else:
            check = False


check = True
user_input = input('Are you male or female? ')
if user_input.upper() == 'MALE':
    male()
elif user_input.upper() == 'FEMALE':
    female()
else:
    while user_input.upper() != 'MALE' or 'FEMALE':
        user_input = input('Are you male or female? ')
        if user_input.upper() == 'MALE':
            male()
        elif user_input.upper() == 'FEMALE':
            female()
