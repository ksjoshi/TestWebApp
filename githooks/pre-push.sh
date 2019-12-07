x=$(git diff --name-only origin/master master)
echo "Git Diff Changes are"
echo $x

if [[ $x = *web* ]]; then
	cd web
	echo " Current Directory is :" 
	pwd
	./gradlew clean build
	cd ..
fi
if [[ $x = *web* ]]; then
	cd demoservicev1
	echo " Current Directory is :"
	./gradlew clean build
	cd ..
fi


