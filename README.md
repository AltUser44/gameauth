GameAuth
=======

GameAuth is a small Java-based authentication example project for game services. It demonstrates a lightweight REST API, user representations, a simple DAO, authentication/authorization hooks, and a healthcheck — organized as a Maven project suitable for IDEs and CI.

Repository layout (important files)

- `pom.xml` and `bin/pom.xml` — Maven build descriptors.
- `gameauth/FIXME/gameauth/src/main/java` — main Java source tree containing application classes.
- `gameauth/FIXME/gameauth/src/main/resources` — runtime resources (banner, config template, assets).
- `com/gamingroom/gameauth/auth` — authentication and authorization classes (`GameAuthenticator`, `GameAuthorizer`, `GameUser`).
- `com/gamingroom/gameauth/controller` — REST controllers exposing API endpoints.
- `com/gamingroom/gameauth/dao` — simple data access layer (`GameUserDB`).
- `com/gamingroom/gameauth/healthcheck` — application healthcheck endpoints.

Features

- Minimal REST API for user information and authentication flows.
- In-memory or configurable DAO for demo and testing.
- AuthN/AuthZ classes illustrating Dropwizard-style security integration.
- Healthcheck endpoint and controller for runtime monitoring.

Technology stack

- Java 8+ (or newer compatible with the project POM)
- Maven for build and dependency management
- Dropwizard-style application structure (see `GameAuthApplication` and `GameAuthConfiguration`)

Prerequisites

- JDK 8 or newer installed and `JAVA_HOME` set.
- Maven installed and on `PATH`.
- (Optional) An IDE such as IntelliJ IDEA or Eclipse for running and debugging.

Build

1. From the project root, run:

    mvn clean package

2. The build produces runnable artifacts under the relevant `target/` directories (for example `gameauth/FIXME/gameauth/target/`).

Run

- From the module directory containing the assembled JAR, run the jar (example):

    # from gameauth/FIXME/gameauth
    java -jar target/<artifact-name>.jar server config.yml

- Alternatively run from your IDE by launching `GameAuthApplication` with the `config.yml` resource or run configuration.

Configuration

- `config.yml` (example location: `gameauth/FIXME/gameauth/config.yml`) contains runtime configuration used by the application. Update ports, logging, and any environment-specific options there.

Testing

- Run unit tests with:

    mvn test

Repository hygiene notes

- There is a repository-level `.gitignore` at the project root which ignores IDE metadata and build artifacts. That prevents irrelevant files (for example Eclipse `.metadata/`) from being added to Git.
- A duplicate `.gitignore` previously existed under `gameauth/FIXME/gameauth/.gitignore`. That duplicate has been removed — keep the root `.gitignore` as the canonical ignore file.

Contributing

- Fork the repo and submit pull requests. Keep changes focused and provide tests where applicable.

Troubleshooting

- Locked files when running `git add`: if an IDE (like Eclipse) holds files such as embedded webview cookie files open, close the IDE or kill the process, then retry the Git command. On Windows you can inspect locks with `tasklist` or use `Handle` from Sysinternals.
- To remove already-tracked IDE files without deleting them locally, run:

    git rm -r --cached .metadata
    git add .gitignore
    git commit -m "Ignore IDE metadata"

License

This project is licensed under the MIT License. See the `LICENSE` file at the repository root for full terms.

Continuous integration

- A GitHub Actions workflow (`.github/workflows/maven.yml`) is included and runs `mvn test` on pushes and pull requests to `master`.

Author

- Kester Nkese

Next steps (optional)

- Add a license badge to the `README.md` (e.g. MIT).
- Adjust the workflow Java version to match the project `pom.xml` if needed.
- Extend CI to run `mvn package` and upload build artifacts.
- I can also run `mvn package` locally and report the produced artifacts if you want.
