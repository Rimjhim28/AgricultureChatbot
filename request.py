import requests

url = 'http://localhost:5000/api'

r = requests.post(url,json={'exp':['how to grow cotton']})
print(r)