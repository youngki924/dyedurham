# Name Sorter

Java 17 command-line application that sorts names by family name, followed by given names. Each non-empty input line must contain one to three given names and a family name. Blank lines are ignored.

## Run

There are three ways to run the sorter. Maven must be installed; the launcher scripts expect Maven on `PATH`.

Shell script (Linux or macOS):

```sh
./name-order ./unsorted-names-list.txt
```

Windows PowerShell:

```powershell
./name-order.cmd ./unsorted-names-list.txt
```

Direct Maven command (Linux, macOS, or Windows):

```sh
mvn exec:java -Dexec.args="./unsorted-names-list.txt"
```

The application prints the sorted names and overwrites `sorted-names-list.txt` in the current working directory.

## Build and test

```sh
mvn verify
```

The GitHub Actions workflow in `.github/workflows/maven.yml` runs this build and test step on pushes and pull requests.
