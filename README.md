# jacoco-tycho-multimodule
This project is a simple test to see if we can use Jacoco in a tycho multimodule project to make the builds fail when the coverage doesn't reach a minimum value.

The support for multi modules is not something supported by the plugin, but it is something that has been documented by the Jacoco team in this [article](https://github.com/jacoco/jacoco/wiki/MavenMultiModule).

We are already doing one of the recommended approaches by using another tool to aggregate the information (in our case SonarQube)

But breaking the build because of not meeting the quality gates is something that even SonarQube discourages (see [article](https://blog.sonarsource.com/why-you-shouldnt-use-build-breaker/).

The recommended approach is to use the notifications feature provided by SonarQube.

With that been said... In the project created a simple script that executes the build 2, in order to generate the data required to verify the jacoco rules are fullfilled.

The first execution generates the data for all modules. 
Because of how jacoco works verifications are done against the code and the tests in each module, and execution data is generated when running the tess.

Because tycho projects have tests in a separate module the following secuence of event will take place:
- Actual product modules won't have any execution data, so checks will not be performed.
- When the associted test module runs, the data for the test and the actual module will be generated.
- Check will be performed in the test code so it the test code doesnt meet the quality gate the build will fail.
- At the end of the build, all data will be merged in a single file
- If the build is executed again, since now the execution data is available, if the actual module code doesnt meet the quality gate the build will fail.

The code as it is right now, has a 50% coverage for branches, and in this project, a 51% coverage has been configured.

Running from the root the following script will result in a build failure:
```
./jacoco.sh
```

Adding a test to improve the coverage, or lowering the % to 0.5 will make the script and in a successfull build.
