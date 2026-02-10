Goal
The goal of this assignment is to master the core of continuous integration. To achieve this goal, the students are asked to implement a small continuous integration CI server. This CI server will only contain the core features of continuous integration. The features are all specified below, as grading criteria.

The grading focuses on the understanding and implementation of the core CI features, but also considers the application of software engineering on the development process, see the grading scheme below.

Development
You must use a development platform (GitHub, GitLab, Bitbucket); KTH GitHub itself has no webhook support so it cannot be used to trigger your CI service. Only the content published on the development platform is used for grading. The content means: 1) the code 2) the issues 3) the pull requests 4) the continuous integration data (if available).

The students can start the task right now, and have to be done at the final grading session for this assignment. Final changes can be made after the grading, up to the deadline.

Architecture
The figure shows the overall architecture of the problem. Note that you are not required to use GitHub (for the repository) and ngrok (to make your server externally visible); you can also use e-mail notification instead of a web front-end. This is just an example.

CI workflow when using GitHub notifications

Roles
Roles of the students: coordinate in the group, ensure everybody is able to contribute, do the work, deliver on time, ask for feedback on the Canvas discussion forum, present the work during the grading appointment.

Roles of the teaching assistants: provide support for students during laboratory sessions, provide support on the Canvas discussion forum, prepare a first version of the grading form.

Roles of the lecturers: final assessment and official grading.

Ethics
Recall that the student code of conduct forbids any kind of plagiarism, between groups in the course, or based on content taken on the internet.

Notes
[prerequisite] We assume basic knowledge of HTTP networking, and its handling in Java. This is required to understand the webhook mechanism of GitHubLinks to an external site.. A basic skeleton implementation a webhook-based CI server is available at https://GitHub.com/KTH-DD2480/smallest-java-ci. Links to an external site.The skeleton is optional, it is provided to help the students getting started. The students can use other languages or frameworks.
[prerequisite] Basic knowledge of RESTLinks to an external site. is strongly recommended. It is required to be able to notify users about CI results with commit statuses (see P3 below), and also for P6.
[recommendation] Dog fooding: it is recommended that the group uses its own CI server during development.
[recommendation] Multiple CI: it is possible to activate several CI services on the same repository. For instance, the students can activate a normal CI service on their repository (e.g., GitHub actions), in addition to their your own CI server.
[challenge] Setting up a server is easy if one has access to a machine that is connected on the Internet, with no firewall or network rules blocking incoming requests (there are several KTH machines such as student-shell.sys.kth.se, student-shell-2.sys.kth.se, student-shell-3.sys.kth.se, with which you have to use ngrok, though). If the students do not have access to such a machine, there is always the solution to tunnel incoming requests: ngrok is a really good solution for this, and its usage is documented in https://GitHub.com/KTH-DD2480/smallest-java-ciLinks to an external site.
[convention] If we all use the same KTH machine, we have to be careful of not using the same network port. The convention is that the students use the port 8000+<group number> (eg port 8012 for group 12, "python -m SimpleHTTPServer 8012")


Features & Grading
The assignment is graded either "Pass" or "Pass with distinction". It contributes to the final course grade according to the grading specification of the course. By default all students of a group have the same grade. However, if there is unbalanced work, as reported by the students or detected by the teaching team, more qualified grading can be applied.

Mandatory features to get a Pass (every point must be achieved):
Task list (mandatory tasks)
Task
Achieved (Yes/no)

Optional comment

P0a

Property: the repository is structured with appropriate folders and contains a good README. The README contains the statement of contributions and the precise dependencies of your project. The project contains a LICENSE that allows the grader to access and use it.

Assessment: The grader assesses the appropriateness of all top-level files and folders. The grader reads the README and the statement of contributions.

P0b

Property: the repository is in a valid state.

Assessment: the group or the grader checks out the repository, and run compilation and testing through a standard way, documented in the README (in particular `mvn test`, `gradle build` or `make`) .
P0c

Property: the repository is self-contained and contains only code, configuration, and documentation needed for this assignment.

A group that mixes Assignment 1 and Assignment 2 in a single repository will fail this assignment.

P1

Property (core CI feature #1 - compilation): the CI server supports compiling the group project, a static syntax check is to be performed for languages without compiler. Compilation is triggered as webhook, the CI server compiles the branch where the change has been made, as specified in the HTTP payload.

Preparation: the students prepare a specific branch called "assessment" (not "master"). The students document in the README how compilation has been implemented and unit-tested.

Assessment: The grader does a commit in a README in a specific branch, and observes on the server's console that compilation is run (observation can also be made through P3 and P6). Optionally, the grader has a look at the implementation or the tests of this feature.

P2

Property (core CI feature #2 - testing): the CI server supports executing the automated tests of the group project. Testing is triggered as webhook, on the branch where the change has been made, as specified in the HTTP payload.

Preparation: the students prepare a specific branch called "assessment" (not "master"). The students document in the README how test execution has been implemented and unit-tested.

Assessment: The grader changes the oracle of an assertion in one test, and observes that tests are executed and at least one fails (the one with the changed assertion). Optionally, the grader has a look at the implementation or the tests of this feature.

P3

Property (core CI feature #3 - notification): the CI server supports notification of CI results. At least one notification mechanism of the following list is implemented:

Commit status: the CI server sets the commit statusLinks to an external site. on the repository (REST APILinks to an external site. for GitHub)
Email: the CI server sends an email to the project member about the build result.
Preparation: The students document in the README how notification has been implemented and unit-tested.

Assessment: The grader observes the status of the change made while assessing P2. Optionally, the grader may look at the implementation or the tests of this feature.

P4

Property (SE): the collaboration is well structured and traceable

Assessment: The grader will open the commit history on GitHub, and will select a minimum of 5 commits, at random, to check that:

every commit is an atomic bug fix or feature, with a clear commit message. A prefix convention is appropriate, eg commit messages starting with "feat", "fix", "doc", "refactor").
the commit contents reflect the commit message, every bug fix or feature commit contains a test
the commits are well balanced among group members
P5

Property (SE): the program is properly documented

Assessment: The grader randomly opens application files (not test files) to check that all public classes and methods are well documented (hintsLinks to an external site.). In addition, the grader checks that the corresponding API documentation has been generated in a browsable format (eg HTML when using Javadoc).

P6

Property (SEMAT):

Assess and document (in one paragraph) your Team (p. 51 in the Essence standardLinks to an external site. v1.2) by evaluating the checklist on p. 52:
In what state are you in? Why? What are obstacles to reach the next state?
Assessment: The grader will read your statement and assess whether it corresponds to an honest and accurate self-evaluation.


To get a  P+: Pass with distinction (at least two properties must be achieved):
Task list (optional tasks)
Task
Achieved (Yes/no)

Optional comment

P7
Property (CI feature): the CI server keeps the history of the past builds. This history persists even if the server is rebooted. Each build is given a unique URL, that is accessible to get the build information (commit identifier, build date, build logs). One URL exists to list all builds.

Preparation: the students document the build list URL in the README.

Assessment: The grader opens the build list URL by clicking on it in the README. The grader randomly clicks on a build and assesses the appropriateness of the information.



P8

Property: the group is creative and proactive, they have done something remarkable, for which they are proud.

Assessment: the students claim in their "Statement of contributions" that they have done something valuable and remarkable in their project. The grader subjectively assess whether it counts towards a distinction.

P9

Property (SE): most of the recent 25 commits (typically 90%) are linked to an issue describing the feature / commit.
Assessment: The grader opens a random sample of commits and assess whether they point to a valid issue. The grader will open a random sample of issues and assess whether they clearly describe (and optionally discuss) a feature or problem (for bugs).