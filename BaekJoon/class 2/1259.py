while True:
    num = input()
    if(int(num) == 0):
            break   
    num = list(num)
    num2 = list(num)
    num2.reverse()
    if(num == num2):
          print('yes')
    else:
          print('no')