import ej.wadapps.app.BackgroundService
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.Reader
import java.net.ServerSocket


class OtherMain : BackgroundService {

    companion object {
        @JvmStatic
        fun main(args: Array<String>?) {
            println("startingg")
            try {
                val server = ServerSocket(8080)
                println("Listening for connection on port 8080 ....")
                while (true) {
                    val clientSocket = server.accept()
                    val isr = InputStreamReader(clientSocket.getInputStream())
                    val reader = BufferedReader(isr as Reader)
                    var line = reader.readLine()
                    while (line.isNotEmpty()) {
                        println(line)
                        line = reader.readLine()
                    }
                }
            } catch (e: IOException) {
                println(e.localizedMessage)
            }
        }
    }

    override fun onStart() {
        main(null)
    }

    override fun onStop() {
        println("stoppped")
    }
}