import socket
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind(('127.0.0.1', 8071))
server_socket.listen()
print("Server is waiting for request")
connection_socket, address = server_socket.accept()
print("Server is connected")
message = "Thank you for connecting me..."
data = message.encode()
connection_socket.send(data)
