n = int(input())
list = []
for i in range(0, 19):
    list.append([])
    for j in range(0, 19):
        list[i].append(0)

for i in range(0, n):
    x, y = map(int, input().split())
    list[x-1][y-1] = 1

for i in range(0, 19):
    for j in range(0, 19):
        print(list[i][j], end=' ')
    print()
