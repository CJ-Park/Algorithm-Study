while True:
    li = list(map(int, input().split()))
    li.sort()

    if(li == [0,0,0]):
        break
    elif(li[0]**2 + li[1]**2 == li[2]**2):
        print("right")
    else:
        print("wrong")