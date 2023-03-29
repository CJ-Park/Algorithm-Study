# 벌집

N = int(input())
num = 0
i = 1
# N-2를 6으로 나눴을 때 몫이 0이면 2칸 / 몫이 2이하면 3칸 / 5이하면 4칸 / 9이하면 5칸
if(N-2 // 6 == 0):
    print(2)
while((N-2) // 6 >= num):
    num = num + i
    i += 1
print(i)