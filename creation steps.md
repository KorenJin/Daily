npx create-react-app daily
cd daily
git branch --> master
npm install gh-pages --save-dev

open package.json file
Add homepage property
"homepage": "https://korenjin.github.io/daily",

add predeploy and deploy scripts
"scripts": {
  //...
  "predeploy": "npm run build",
  "deploy": "gh-pages -d build"
}

Add remote repo
git remote add origin https://github.com/KorenJin/daily.git
If error check current remote:
git remote get-url origin
If different remove that one and put the new one above
git remote remove origin

npm run deploy

By default, the new commit on the gh-pages branch will have a commit message of "Updates". You can specify a custom commit message via the -m option, like this:
npm run deploy -- -m "Deploy React app to GitHub Pages"

Configure GitHub Pages
1. Navigate to the GitHub Pages settings page
    - In your web browser, navigate to the GitHub repository
    - Above the code browser, click on the tab labeled "Settings"
    - In the sidebar, in the "Code and automation" section, click on "Pages"
2. Configure the "Build and deployment" settings like this:
    - Source: Deploy from a branch
    - Branch:
        - Branch: gh-pages
        - Folder: / (root)
Click on the "Save" button
That's it! The React app has been deployed to GitHub Pages! 🚀

At this point, the React app is accessible to anyone who visits the homepage URL you specified in Step 4. For example, the React app I deployed is accessible at https://korenjin.github.io/daily.

9. Store the React app's source code on GitHub
In a previous step, the gh-pages npm package pushed the distributable version of the React app to a branch named gh-pages in the GitHub repository. However, the source code of the React app is not yet stored on GitHub.

In this step, I'll show you how you can store the source code of the React app on GitHub.

Commit the changes you made while you were following this tutorial, to the master branch of the local Git repository; then, push that branch up to the master branch of the GitHub repository.

git add .
git commit -m "Configure React app for deployment to GitHub Pages"
git push origin master

I recommend exploring the GitHub repository at this point. It will have two branches: master and gh-pages. The master branch will contain the React app's source code, while the gh-pages branch will contain the distributable version of the React app.

Always open master branch for code edition, gh-pages branch is defualt for Github Pages to work, so this can't be changed.



Other libraries:

- For translations of text
npm install react-i18next i18next