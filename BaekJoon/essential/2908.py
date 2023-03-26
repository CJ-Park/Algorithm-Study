# 1트

a,b = map(str, input().split())

for i in range(0,3):
    if(a[2-i] < b[2-i]):
        print(b[::-1])
        break
    elif(a[2-i] > b[2-i]):
        print(a[::-1])
        break