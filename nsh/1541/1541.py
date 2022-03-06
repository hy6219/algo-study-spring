s = input()

s = s.split('-')

def sum_s(sth):
    if sth.find('+') != -1:
        n = sth.split('+')
        sum = 0
        for i in n:
            if i != '+':
                sum += int(i)
        return sum
    return int(sth)

ans = int(s[0])
for ns in s[1:]:
    ans -= sum_s(ns)
    
print(ans)
