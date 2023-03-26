s = list(map(str, input()))
success = False
for i in range(97, 123):
    for j in s:
        if(j == chr(int(i))):
            print(s.index(j), end=' ')
            success = True
            break
        else:
            success = False
    if(not success):
        print('-1', end=' ')