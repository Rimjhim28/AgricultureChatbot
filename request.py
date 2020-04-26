import requests
from googletrans import Translator

url = 'http://localhost:5000/api'
query = 'कपास कैसे बढ़ती है'
t = Translator().translate(query)
new_query = t.text
r = requests.post(url,json={'exp':[new_query]})
print(r)
