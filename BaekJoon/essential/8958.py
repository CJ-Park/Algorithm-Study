# OX 문제 점수 구하기
# O가 연속되면 점수 상승
n = int(input())
score = 0
before = 1
correct = False

for _ in range(n):
    s = input()
    for i in s:
        if i == 'O' and correct == True:
            before += 1
            score += before
        elif i == 'O' and correct == False:
            score += 1
            correct = True
            before = 1
        else:
            correct = False
            before = 1
    print(score)
    score = 0
    before = 1
    correct = False
            

