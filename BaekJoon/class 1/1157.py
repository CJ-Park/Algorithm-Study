# 2트
# 문자열 길이에 따른 시간초과 생각 못했음 -> 중복되는 문자면 카운팅 패스

s = input()
s = s.upper()
count = dict()
counter = 0
res = ''

for i in s:
    if(not count.get(i)):
        count[i] = s.count(i)

for key in count.keys():
    if(int(counter) < count[key]):
        counter = count[key]
        res = key
    elif(int(counter) == count[key]):
        res = '?'
print(res)
    