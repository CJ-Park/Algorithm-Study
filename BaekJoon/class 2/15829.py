L = int(input())
s = input()
s = s[:L]
res = 0
for i in range(0, len(s)):
    res += (ord(s[i]) - 96) * (31 ** i)
print(res % 1234567891)