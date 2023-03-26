# 음계 판단 문제
li = list(map(int, input().split()))
a = [1,2,3,4,5,6,7,8]
b = a[:] # 
b.sort(reverse=True)

if li == a:
    print("ascending")
elif li == b:
    print("descending")
else:
    print("mixed")