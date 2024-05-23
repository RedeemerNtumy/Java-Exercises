import socket,asyncio


async def server():
    s=socket.socket()
    port=12607
    s.bind(('',port))
    s.listen(10)
    print("Server started. Waiting for the message")
    while True:
        c,addr= s.accept()
        content= c.recv(100).decode()
        print(f"Message received from {addr}")
        if content =="Done":
            c.close()
            break
    print (content)
asyncio.run(server())
