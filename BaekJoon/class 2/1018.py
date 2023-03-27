# 1시간 소요
# 2차원 배열 잘라내기 정리

def case1(board):
    cnt = 0
    for i in range(0, 8):
        for j in range(0, 8):
            if((i+j)%2 == 0 and board[i][j] == 'B'):
                cnt += 1
            elif((i+j)%2 == 1 and board[i][j] == 'W'):
                cnt += 1
    return cnt

def case2(board):
    cnt = 0
    for i in range(0, 8):
        for j in range(0, 8):
            if((i+j)%2 == 0 and board[i][j] == 'W'):
                cnt += 1
            elif((i+j)%2 == 1 and board[i][j] == 'B'):
                cnt += 1
    return cnt

N, M = map(int, input().split())
block = []
board = []
cntList = []

for i in range(N):
    block.append(input())

for i in range(N-7):
    for j in range(M-7):
        board = [a[j:j+8] for a in block[i:i+8]] 
        cntList.append(case1(board))
        cntList.append(case2(board))

print(min(cntList))