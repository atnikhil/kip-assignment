
import java.io.File

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


class FutureFile {

  def findDirectory(dir: String): Future[List[File]] = Future {
    val directory = List(new File(dir))
    getFiles(directory)

  }

  private def getFiles(dir: List[File], output: List[File] = Nil): List[File] = {
    dir match {
      case x :: y => getFiles(y ::: x.listFiles.filter(_.isDirectory).toList,
        output ::: x.listFiles.filter(_.isFile).toList)
      case _ => output
    }
  }
}

object FutureApplication extends App {

  val futureObject = new FutureFile
  val result = futureObject.findDirectory("src/main/scala")
  val result = futureObject.findFilesInDirectory("src/main/Folder1")
  result onComplete {
    case Success(ans) => println(ans)
    case Failure(e) => println(e.getMessage)
  }

  Thread.sleep(5000)
}

}