import socket
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect(("127.0.0.1", 8071))
print("Connected")
message = client_socket.recv(1024)
data = message.decode()
print(data)