# Import libraries
import numpy as np
from flask import Flask, request, jsonify
import pickle

app = Flask(__name__)

# Load the model
model = pickle.load(open('model.pkl','rb'))

@app.route('/api', methods=['POST'])
def predict():
	data = request.get_json(force=True)
	print(np.array(data['exp']).shape)
	prediction = model.predict(np.array(data['exp']).reshape(-1,1))
	output = prediction[0]
	return jsonify(output)

if __name__ == '__main__':
	app.run(port=5000, debug=True)