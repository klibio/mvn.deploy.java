# WIP

```bash
export 'MAVEN=/Users/peterkir/eval/apache-maven-3.9.9'
export 'PATH=$MAVEN/bin:$PATH'

export JAVA_HOME_21=/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home
export PATH=$JAVA_HOME_21/bin:$PATH

export github_username=peterkir
export github_token=<token-here>

export REPOSILITE_ID=reposilite.klib.io
export REPOSILITE_URL=https://reposilite.klib.io
export REPOSILITE_USER_RELEASE=klib-releases
export REPOSILITE_TOKEN_RELEASE=<token-here>
export REPOSILITE_USER_SNAPSHOT=klib-snapshots
export REPOSILITE_TOKEN_SNAPSHOT=<token-here>

export CENTRAL_USER=<user-here>
export CENTRAL_TOKEN=<token-here>

# build local
./mvnw clean verify
# execute local
java -jar target/mvn.deploy.java-0.0.1-SNAPSHOT.jar

# build and deploy to reposilite.klib.io
./mvnw clean deploy > _log$(date +'%Y.%m.%d-%H.%M.%S')_out.log

# launching gpg-agent
gpg-agent
# store gpg password
echo "test" | gpg --clearsign
# publish to maven central
./mvnw clean deploy -P maven-publish-central > _log/$(date +'%Y.%m.%d-%H.%M.%S')_out.log



```

## Links

[Maven release ](https://central.sonatype.org/publish/publish-portal-maven/#automatic-publishing)
[Maven snapshots](https://central.sonatype.org/publish/publish-portal-snapshots/#publishing-via-other-methods)
