// One of my first progrmas in Go. Just a hello world, as expected
package greeting

const testVersion = 3

// HelloWorld needs a comment documenting it as package does.
func HelloWorld(s string) string {
	if s != "" {
		return "Hello, " + s + "!"
	}
	return "Hello, World!"
}
