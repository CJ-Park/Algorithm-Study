N = int(input())
list = []
res = 0
s = input()
for i in s:
    list.append(i)
for i in range(N):
    res += int(list[i])
print(res)