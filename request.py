import requests
from googletrans import Translator

url = 'http://localhost:5000/api'
query = 'कपास कैसे बढ़ती है'
r = requests.post(url,json={'exp':[query]})
print(r)
