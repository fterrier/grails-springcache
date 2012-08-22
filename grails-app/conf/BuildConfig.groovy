grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
	inherits("global") {
		excludes "xml-apis"
	}
	log "warn"
	repositories {
		grailsHome()
		grailsPlugins()
		grailsCentral()
		mavenLocal()
		mavenRepo "http://m2repo.spockframework.org/ext/"
		mavenRepo "http://m2repo.spockframework.org/snapshots/"
		mavenCentral()
	}
	dependencies {
		compile("net.sf.ehcache:ehcache-web:2.0.3") {
			excludes "ehcache-core", "xml-apis" // ehcache-core is provided by Grails
		}
		test("org.objenesis:objenesis:1.2") {
			exported = false
		}
	}
	plugins {
		test(":spock:0.6") {
			export = false
		}
		build(":release:1.0.0.RC3") {
			export = false
		}
	}
}
