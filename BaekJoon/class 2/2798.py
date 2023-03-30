N, M = map(int, input().split())
list = list(map(int, input().split()))[:N]
list.sort()
res = 0

for i in range(0, len(list) - 2):
    for j in range(i + 1, len(list) - 1):
        for k in range(i + 2, len(list)):
            summary = list[i] + list[j] + list[k]
            if(res < summary and summary <= M):
                res = summary

print(res)
    