# 2트 -> 2도 소수인거 까먹음
N = int(input())
li = list(map(int, input().split()))
li = li[:N]
count = 0
res = 0

for i in li:
    for j in range(1, i//2 + 2):
        if(i == 1 or j == 1):
            continue
        res = i % j
        if(res == 0):
            break
    if(res != 0 or i == 2):
        count += 1

print(count)