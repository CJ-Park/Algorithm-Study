import datetime

d = datetime.datetime.now()
date = d.strftime('%Y-%m')
print(date + '-', d.day+1, sep='')