N = int(input())

originNum = 1

while(originNum < N):
    divSum = 0
    for i in str(originNum):
        divSum += int(i)
    if(originNum + divSum == N):
        print(originNum)
        break
    originNum += 1

if(originNum >= N):
    print(0)
