Cracking the Caesar Cipher
You are trying to eavesdrop on communications between your enemies. You have managed
to intercept their messages and have discovered that they are using a Caesar cipher. You
also have a number of plaintext snippets (“cribs”) that you believe are present in the
plaintext message.
Your challenge is to write a Java microservice that attempts to crack the Caesar cipher used
by your enemies. It should accept the input as a JSON POST on the path /decrypt.
Your service will be passed JSON containing:
1. The encrypted ciphertext.
2. The list of plaintext snippets, or “cribs”.
Example input is:
POST to /decrypt with a body of:
{
 “ciphertext” : “VJKUKUCUGETGVOGUUCIG”,
 “cribs” : [“THI”, “MES”]
}
The service should return JSON containing the full decrypted plaintext version of the
encrypted text.
An example response might be:
{
 “plaintext” : “THISISASECRETMESSAGE”
}
Notes:
• All input and output messages are in upper case, with no spaces.
• The Caesar cipher shift used by you enemies changes between messages, but it is
always the same for a given cipher text.
• Your enemies may be aware of what you are trying to do and may try to confuse
your algorithm, but they are not smart enough to choose another cipher.
• You are certain that all of the cribs provided do appear in the plaintext.
• Try to showcase what you believe should be present in a mission-critical application
project.
• You should aim to spend no more than around two hours on this challenge.
• You are encouraged to use Spring Boot & Gradle, though this is not compulsory.
