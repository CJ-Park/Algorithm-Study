# 2트
# 조건 생각 제대로 하기, N번째 손님 N-1로 생각!

n = int(input())

for _ in range(0, n):
    H, W, N = map(int, input().split())
    h = (N-1) // H + 1
    h = "%02d" % h
    d = (N-1) % H + 1
    print(str(d) + str(h))
